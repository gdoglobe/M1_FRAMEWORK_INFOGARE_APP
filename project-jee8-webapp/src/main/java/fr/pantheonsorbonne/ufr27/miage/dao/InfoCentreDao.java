package fr.pantheonsorbonne.ufr27.miage.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import fr.pantheonsorbonne.ufr27.miage.conf.PersistenceConf;
import fr.pantheonsorbonne.ufr27.miage.jpa.InfoCentre;


@ManagedBean
//@Stateless
public class InfoCentreDao implements Dao<InfoCentre>{
	
	@Inject
	//@PersistenceContext(synchronization = SynchronizationType.SYNCHRONIZED, unitName = "default", type = PersistenceContextType.EXTENDED )
	EntityManager em;
	public InfoCentreDao() {
		em = PersistenceConf.entityManager;
	}
	public InfoCentreDao(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public InfoCentre save(InfoCentre infocentre) {
		executeInsideTransaction(entityManager -> entityManager.persist(infocentre));
		return infocentre;
	}

	@Override
	public InfoCentre find(long id) {
		
		InfoCentre ifc = null;

		Optional<InfoCentre> optIfc = Optional.ofNullable(em.find(InfoCentre.class, id));
		if (optIfc.isPresent()) {
			ifc = optIfc.get();
		}

		return ifc;
	}
	

	@Override
	public InfoCentre update(InfoCentre infocentre) {
		executeInsideTransaction(entityManager -> entityManager.merge(infocentre));
		return infocentre;
	}

	@Override
	public void delete(InfoCentre infocentre) {
		executeInsideTransaction(entityManager -> entityManager.remove(infocentre));
	}

	@Override
	public List<InfoCentre> findAll() {
		List<InfoCentre> resultList = em.createQuery("Select ifc From InfoCentre ifc", InfoCentre.class).getResultList();
        return resultList;
	}

	private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            action.accept(em);
            tx.commit(); 
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }
}
