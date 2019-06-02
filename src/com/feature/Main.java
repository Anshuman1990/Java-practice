package com.feature;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("DBChkResultID", "29741");
		data.put("ScreeningID", "36000");
		data.put("OIGLEIE", "U");
		data.put("GSAEPLS", "U");
		data.put("MCSIS_MR_NPI_STATUS", "F");
		data.put("MCSIS_MR_NAME_ADDR_STATUS", "U");
		data.put("MCSIS_MD_NPI_STATUS", "F");
		data.put("MCSIS_MD_NAME_ADDR_STATUS", "T");
		
		String mcsisType = data.entrySet().stream().filter(
				map -> (map.getKey().contains("MCSIS") && "T".equalsIgnoreCase(map.getValue() != null ? map.getValue().toString() : "")))
				.map(map -> map.getKey()).collect(Collectors.joining(","));
		
		System.out.println(mcsisType);
	}
}

