package com.sisteminha.resources;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sisteminha.entities.Evaluation;
import com.sisteminha.services.EvaluationService;

@RestController
@RequestMapping(path = "evaluation")
public class EvaluationResource extends LoggedResource {

	@Autowired
	private EvaluationService service;

	// TODO esse m�todo tem que mudar de acordo com a role do user logado
	@RequestMapping(method = RequestMethod.GET)
	public List<Evaluation> findAll() {
		return service.findAll(getLoggedIncubator());
	}

	@RequestMapping(path = "{id}", method = RequestMethod.GET)
	public Evaluation find(@PathVariable("id") Long id) {
		return service.find(getLoggedIncubator(), id);
	}

	@Transactional
	@RequestMapping(path = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		service.delete(getLoggedIncubator(), id);
	}
}