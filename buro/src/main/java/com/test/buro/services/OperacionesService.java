package com.test.buro.services;

import com.test.buro.api.objects.OperacionesRequest;
import com.test.buro.api.objects.OperacionesResponse;

public interface OperacionesService {

	OperacionesResponse doOperacione(OperacionesRequest request);
	
	OperacionesResponse getOperacione(OperacionesRequest request);
}
