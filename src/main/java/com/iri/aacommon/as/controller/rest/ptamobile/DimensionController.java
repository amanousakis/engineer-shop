package com.iri.aacommon.as.controller.rest.ptamobile;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.iri.aacommon.controller.ancestors.AbstractController;
import com.iri.aacommon.domain.system.Response;
import com.iri.aacommon.exception.IriAnalyticServerException;
import com.iri.aacommon.exception.IriDataException;
import com.iri.aacommon.exception.IriIOException;
import com.iri.aacommon.exception.ResourceNotFoundException;

/**
 * The Class DimensionController is responsible to accept and fulfill all analytic server requests regarding dimensions.
 */
@RestController
@JsonIgnoreProperties(ignoreUnknown = true)
public class DimensionController extends AbstractController {

	/**
	 * Gets a specific dimension in {@link AnalyticServerDto} format.
	 *
	 * @param request the request
	 * @param moduleId the module id
	 * @param customerId the customer id
	 * @param dimensionId the dimension id
	 * @param hierarchyType the hierarchy type for which the XQL select will be executed
	 * @param dimensionCategory the dimension category from which the XQL select should start
	 * @return the dimension
	 * @throws IriIOException
	 * @throws ResourceNotFoundException
	 * @throws IriDataException
	 * @throws IriAnalyticServerException
	 */
	@RequestMapping(value = "/modules/{moduleId}/customers/{customerId}/dimensions/{dimensionId}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@Profiled(tag = "DimensionController.getDimension")
	public Response<List<String>> getDimension(final HttpServletRequest request, @PathVariable final long moduleId, @PathVariable final long customerId, @PathVariable final String dimensionId, @RequestParam(required = false) final String hierarchyType,
					@RequestParam(required = false) final String dimensionCategory) throws IriAnalyticServerException, IriDataException, ResourceNotFoundException, IriIOException {

		this.LOG.debug("moduleID: {}, customerId: {}, dimensionId: {}, hierarchyType: {}, dimensionCategory: {}.", moduleId, customerId, dimensionId, hierarchyType, dimensionCategory);

		final List<String> result = new ArrayList<String>();
		final Response<List<String>> response = new Response<List<String>>(result);

		return response;
	}


}
