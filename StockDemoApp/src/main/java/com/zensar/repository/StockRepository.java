package com.zensar.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zensar.entity.StockEntity;

public interface StockRepository extends JpaRepository<StockEntity, Integer> {
	
	List<StockEntity> findByName(String stockName);
	
	@Query(value="SELECT se FROM StockEntity AS se WHERE se.name=:stockName")//JPQL
	List<StockEntity> getStocksByName(String stockName);
	
	@Query(value="SELECT * FROM STOCKS WHERE name=:stockName", nativeQuery=true)
	List<StockEntity> getStocksByNameSQL(String stockName);
	
	List<StockEntity>findByNameContains(String nameLike);
	List<StockEntity>findByNameContaining(String nameLike);
	List<StockEntity>findByNameIsContaining(String nameLike);
	
	@Query(value="SELECT se FROM StockEntity AS se WHERE se.name LIKE %:nameLike%")
	List<StockEntity> getByNameLikeQuery(String nameLike);
	
	@Query(value="SELECT * FROM STOCKS WHERE name LIKE =:nameLike", nativeQuery=true)
	List<StockEntity> getByNameLikeQuerySQL(String nameLike);
	
	List<StockEntity> findByOrderByNameAsc();
	List<StockEntity> findByOrderByNameDesc();
	
	@Query(value="SELECT se FROM StockEntity AS se ORDER BY se.name")
	List<StockEntity> sortStocksByNameAsc();
	
	@Query(value="SELECT se FROM StockEntity AS se ORDER BY se.name DESC")
	List<StockEntity> sortStocksByNameDesc();

}
