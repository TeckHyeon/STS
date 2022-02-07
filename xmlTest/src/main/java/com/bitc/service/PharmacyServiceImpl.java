package com.bitc.service;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import com.bitc.dto.PharmacyFullDataBodyDto;
import com.bitc.dto.PharmacyFullDataDto;
import com.bitc.dto.PharmacyFullDataItemDto;
import com.bitc.dto.PharmacyFullDataItemsDto;

@Service
public class PharmacyServiceImpl implements PharmacyService {

	@Override
	public List<PharmacyFullDataItemDto> getItemList() throws Exception {
		JAXBContext jc = JAXBContext.newInstance(PharmacyFullDataDto.class);

		Unmarshaller um = jc.createUnmarshaller();

		PharmacyFullDataDto fulldata = (PharmacyFullDataDto) um
				.unmarshal(new File("C://Users//rims2//Desktop//JSPBackup//STS//pharmacydata.xml"));
		
		PharmacyFullDataBodyDto body = fulldata.getBody();
		PharmacyFullDataItemsDto items = body.getItems();
		List<PharmacyFullDataItemDto> itemList = items.getItemList();
		
		return itemList;
	}

	@Override
	public List<PharmacyFullDataItemDto> getItemListRange(String strUrl) throws Exception {

		List<PharmacyFullDataItemDto> itemList = null;
		
		URL url = null;
		HttpURLConnection urlConn = null;
		try {
			url = new URL(strUrl);
			urlConn = (HttpURLConnection)url.openConnection();
			urlConn.setRequestMethod("GET");
			
			JAXBContext jc = JAXBContext.newInstance(PharmacyFullDataDto.class);

			Unmarshaller um = jc.createUnmarshaller();

			PharmacyFullDataDto data = (PharmacyFullDataDto)um.unmarshal(url);

			PharmacyFullDataBodyDto body = data.getBody();
			PharmacyFullDataItemsDto items = body.getItems();
			itemList = items.getItemList();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (urlConn != null) {
				urlConn.disconnect();
			}
		}
		
		return itemList;
	}

}
