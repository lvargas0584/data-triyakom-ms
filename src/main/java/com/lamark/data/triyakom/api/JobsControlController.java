package com.lamark.data.triyakom.api;

import com.lamark.architecture.corems.api.BaseController;
import com.lamark.architecture.corems.util.DateUtil;
import com.lamark.data.triyakom.core.service.JobsControlService;
import com.lamark.shared.dto.JobsControlDto;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.text.SimpleDateFormat;

@Path("/data/v1/triyacom/jobscontrol")
public class JobsControlController extends BaseController {
    public static final SimpleDateFormat MYSQL_DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Inject
    JobsControlService jobsControlService;

    @GET
    @Path("/findByOperatorAndProcess/{operator}/{process}")
    @Produces("application/json")
    public Response findByOperatorAndProcess(@PathParam("operator") Integer operator, @PathParam("process") Integer process){
        return buildSuccessWrapperResponse(jobsControlService.findByOperatorAndProcess(operator, process));
    }

    @GET
    @Path("/saveJobsControl/{operator}/{process}/{startDate}/{endDate}")
    public void saveJobsControl( @PathParam("operator") Integer operator, @PathParam("process") Integer process,
                                 @PathParam("startDate") String startDate, @PathParam("endDate") String endDate){
        JobsControlDto jobsControlDto = new JobsControlDto();
        jobsControlDto.setStartDate(DateUtil.getDate(startDate, MYSQL_DATETIME_FORMAT));
        jobsControlDto.setEndDate(DateUtil.getDate(endDate, MYSQL_DATETIME_FORMAT));
        jobsControlDto.setOperator(operator);
        jobsControlDto.setProcess(process);
        Uni.createFrom().item(jobsControlDto).emitOn(Infrastructure.getDefaultWorkerPool()).subscribe()
                .with(jobsControlService::saveJobsControl, Throwable::printStackTrace);
    }


    @GET
    @Path("/updateJobsControl/{id}/{operator}/{process}/{startDate}/{endDate}")
    public void updateJobsControl( @PathParam("id") Integer id, @PathParam("operator") Integer operator,
                                   @PathParam("process") Integer process, @PathParam("startDate") String startDate, @PathParam("endDate") String endDate){
        JobsControlDto jobsControlDto = new JobsControlDto();
        jobsControlDto.setId(id);
        jobsControlDto.setStartDate(DateUtil.getDate(startDate, MYSQL_DATETIME_FORMAT));
        jobsControlDto.setEndDate(DateUtil.getDate(endDate, MYSQL_DATETIME_FORMAT));
        jobsControlDto.setOperator(operator);
        jobsControlDto.setProcess(process);
        Uni.createFrom().item(jobsControlDto).emitOn(Infrastructure.getDefaultWorkerPool()).subscribe()
                .with(jobsControlService::updateJobsControl, Throwable::printStackTrace);
    }

}
