package com.lamark.data.triyakom.api;

import com.lamark.architecture.corems.api.BaseController;

import com.lamark.data.triyakom.core.service.RetryService;
import com.lamark.shared.dto.RetryDto;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.infrastructure.Infrastructure;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/data/v1/triyacom/retry")
public class RetryController extends BaseController {

    @Inject
    RetryService retryService;

    @GET
    @Path("/findRetryById/{id}")
    @Produces("application/json")
    public Response findRetryById(@PathParam("id")  Long id ){
        return buildSuccessWrapperResponse(retryService.findRetryById(id));
    }

    @POST
    @Path("/save")
    public void saveRetry( RetryDto retryDto){
        Uni.createFrom().item(retryDto).emitOn(Infrastructure.getDefaultWorkerPool()).subscribe()
                .with(retryService::saveRetry, Throwable::printStackTrace);
    }

    @POST
    @Path("/update")
    public void updateRetry( RetryDto retryDto){
        Uni.createFrom().item(retryDto).emitOn(Infrastructure.getDefaultWorkerPool()).subscribe()
                .with(retryService::updateRetry, Throwable::printStackTrace);
    }

    @GET
    @Path("/findByHourAndDate")
    @Produces("application/json")
    public Response findByHourAndDateRetryAndEnableIsTrue(){
        return buildSuccessWrapperResponse(retryService.findByHourAndDateRetryAndEnableIsTrue());
    }

}
