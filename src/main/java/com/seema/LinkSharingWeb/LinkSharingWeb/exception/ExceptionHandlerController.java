package com.seema.LinkSharingWeb.LinkSharingWeb.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(Exception.class)
    public ModelAndView internalServerError(Exception ex, WebRequest webRequest) {
        logger.error(ex.getMessage());
        ModelAndView modelAndView = new ModelAndView("404");
        return modelAndView;
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public ModelAndView recordNotFoundException(RecordNotFoundException ex, WebRequest webRequest) {
        logger.error(ex.getMessage());
        ModelAndView modelAndView = new ModelAndView("404");
        return modelAndView;
    }
}
