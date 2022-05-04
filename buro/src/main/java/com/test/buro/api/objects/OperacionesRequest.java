package com.test.buro.api.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperacionesRequest {

	 @JsonProperty("id") String id;
	 
     @JsonProperty("numero_1") String numero1;
     
     @JsonProperty("numero_2") String numero2;
     
     @JsonProperty("operacion") String operacion;
	

}
