package com.test.buro.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.buro.api.objects.OperacionesRequest;
import com.test.buro.api.objects.OperacionesResponse;
import com.test.buro.services.OperacionesService;


@RestController
public class OperacionesController {

	@Autowired
	private OperacionesService service;
	

	@PostMapping("/operaciones")
	public ResponseEntity<OperacionesResponse> operacionesPost(@RequestBody OperacionesRequest request){
		return new ResponseEntity<>(service.doOperacione(request), HttpStatus.OK);
	}
	

	@GetMapping("/operaciones")
	public ResponseEntity<OperacionesResponse> operacionesGet(@RequestBody OperacionesRequest request){
		return new ResponseEntity<>(service.getOperacione(request), HttpStatus.OK);
	}
}
