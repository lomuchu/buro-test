package com.test.buro.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.buro.api.objects.OperacionesRequest;
import com.test.buro.api.objects.OperacionesResponse;
import com.test.buro.models.Operaciones;
import com.test.buro.repositories.OperacionesRepository;
import com.test.buro.services.OperacionesService;
import com.test.buro.utils.Utileria;

@Service
public class OperacionesServicesImpl implements OperacionesService {

	@Autowired
	private OperacionesRepository repository;

	
	@Override
	public OperacionesResponse doOperacione(OperacionesRequest request) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		OperacionesResponse response = new OperacionesResponse();
		
		try {

			
			Operaciones o = new Operaciones();
			String result = Utileria.getResult(request.getNumero1(), request.getNumero2(), request.getOperacion());
			
			o.setId(Long.parseLong(request.getId()));
			o.setContenido(mapper.writeValueAsString(request));
			
			o.setResultado(Utileria.encrypt(result));

			
			repository.save(o);

			
			response.setId(request.getId());
			response.setResultado(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
		return response;
	}

	@Override
	public OperacionesResponse getOperacione(OperacionesRequest request) {
		OperacionesResponse response = new OperacionesResponse();
		try {

			
			Operaciones o = repository.findById(Long.parseLong(request.getId())).orElse(null);
			if(o != null) {
				response.setId(String.valueOf(request.getId()));
				response.setResultado(Utileria.decrypt(o.getResultado()));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
