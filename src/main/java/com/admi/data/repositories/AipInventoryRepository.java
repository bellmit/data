package com.admi.data.repositories;

import com.admi.data.entities.AipInventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface AipInventoryRepository extends JpaRepository<AipInventoryEntity, Long> {

	List<AipInventoryEntity> findAllByDealerIdAndDataDate(Long dealerId, LocalDate dataDate);


	@Transactional
	@Modifying
	@Query( value = "CALL DELETE_AIP_INVENTORY_P()",
			nativeQuery = true)
	void deleteOldInventory();
}
