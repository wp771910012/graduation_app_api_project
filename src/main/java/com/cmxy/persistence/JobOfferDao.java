package com.cmxy.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmxy.entity.JobOffer;
@Repository
public interface JobOfferDao extends JpaRepository<JobOffer, Long> {

}
