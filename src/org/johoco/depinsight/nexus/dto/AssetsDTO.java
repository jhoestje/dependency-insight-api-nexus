package org.johoco.depinsight.nexus.dto;


import java.util.List;

import lombok.Data;

@Data
public class AssetsDTO {
//	{
//		  "items": [
//		   
//		  ],
//		  "continuationToken": "string"
//		}
	
	
	private String continuationToken;
	private List<AssetDTO> items;
}
