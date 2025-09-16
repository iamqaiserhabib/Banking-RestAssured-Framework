package com.api.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter {

    private static final Logger logger = LogManager.getLogger(LoggingFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {

        // Log request details
        logRequest(requestSpec);

        // Proceed with the request and get the response
        Response response = ctx.next(requestSpec, responseSpec);

        // Log response details
        logResponse(response);

        return response;
    }
//
//    private void logRequest(FilterableRequestSpecification requestSpec) {
//        logger.info("=== Request ===");
//        logger.info("Method: {}", String.valueOf(requestSpec.getMethod()));
//        logger.info("URI: {}", String.valueOf(requestSpec.getURI()));
//        logger.info("Headers: {}", String.valueOf(requestSpec.getHeaders()));
//        if (requestSpec.getBody() != null) {
//            logger.info("Body: {}", String.valueOf(requestSpec.getBody()));
//        }
//    }
    
    private void logRequest(FilterableRequestSpecification requestSpec) {
        logger.info("=== Request ===");
        logger.info("Method: {}", requestSpec.getMethod());
        logger.info("URI: {}", requestSpec.getURI());
        logger.info("Headers: {}", requestSpec.getHeaders());

        Object body = requestSpec.getBody();
        if (body != null) {
            String safeBody;
            try {
                safeBody = body.toString();  // Always convert to string explicitly
            } catch (Exception e) {
                safeBody = "[Unable to convert body to string: " + e.getMessage() + "]";
            }
            logger.info("Body: {}", safeBody);
        }
    }


    private void logResponse(Response response) {
        logger.info("=== Response ===");
        logger.info("Status Code: {}", response.getStatusCode());
        logger.info("Headers: {}", String.valueOf(response.getHeaders()));
        logger.info("Body: {}", response.getBody().asPrettyString());
    }
}
