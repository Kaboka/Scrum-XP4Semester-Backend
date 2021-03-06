package service;

import WebServices.Subject;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Stateless
@Path("webservices.subject")
public class SubjectFacadeREST extends AbstractFacade<Subject> {
    @PersistenceContext(unitName = "SCRUMWebServicePU")
    private EntityManager em;

    public SubjectFacadeREST() {
        super(Subject.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Subject entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(Subject entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Subject find(@PathParam("id") String id) {
        return (Subject) em.createNamedQuery("Subject.findByName").setParameter("name",id).getSingleResult();
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Subject> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Subject> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
