package com.lamark.data.triyakom.api;

import com.lamark.architecture.corems.api.BaseController;
import com.lamark.architecture.corems.exception.BaseException;

import com.lamark.data.triyakom.core.service.RegistrationService;
import com.lamark.shared.dto.RegistrationDto;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.infrastructure.Infrastructure;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/data/v1/triyacom/registration")
public class RegistrationController extends BaseController {

    @Inject
    RegistrationService registrationService;

    @POST
    public void saveRegistration(RegistrationDto registration) {
        Uni.createFrom().item(registration).emitOn(Infrastructure.getDefaultWorkerPool()).subscribe()
                .with(registrationService::saveRegistration, Throwable::printStackTrace);
    }

    @POST
    @Path("/returnId")
    public Response saveRegistrationReturnId(RegistrationDto registration) throws BaseException {
        return buildSuccessWrapperResponse(registrationService.saveRegistration(registration));
    }

    @GET
    @Path("/findByPushId/{pushId}")
    public RegistrationDto findByPushId(@PathParam("pushId") String pushId) {
        return registrationService.findByPushId(pushId);
    }
}
