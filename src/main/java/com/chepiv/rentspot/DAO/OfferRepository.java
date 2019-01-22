package com.chepiv.rentspot.DAO;

import com.chepiv.rentspot.domain_core.Offer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by chepiv on 20.01.2019.
 * Contact: chepurin.ivan@gmail.com
 * Github:chepiv
 */
@Repository
public interface OfferRepository extends CrudRepository<Offer,Long> {
}
