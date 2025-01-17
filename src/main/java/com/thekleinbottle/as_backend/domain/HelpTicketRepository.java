package com.thekleinbottle.as_backend.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface HelpTicketRepository extends CrudRepository <HelpTicket, Long> {

    @Query("select t from HelpTicket t where t.isOpen = true")
    List<HelpTicket> findByIsOpen(@Param("isOpen") boolean isOpen);

}
