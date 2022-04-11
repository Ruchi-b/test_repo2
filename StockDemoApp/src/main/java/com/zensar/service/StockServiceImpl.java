package com.zensar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zensar.dto.Stock;
import com.zensar.entity.StockEntity;
import com.zensar.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	StockRepository stockRepo;
	
	ModelMapper model= new ModelMapper();

	private String stockName;
	
	@Override
	public boolean deleteAllStocks() {
		stockRepo.deleteAll();
		return true;
	}

	@Override
	public boolean deleteStockById(int stockId) {
		if(stockRepo.existsById(stockId)) {
			stockRepo.deleteById(stockId);
			return true;
		}
		return false;
	}

	@Override
	public Stock updateStock(int stockId, Stock updatedStock) {
		Optional<StockEntity> stockEntity2= stockRepo.findById(stockId);
		if(stockEntity2.isPresent()) {
			StockEntity s2= stockEntity2.get();
			s2.setName(updatedStock.getName());
			s2.setMarketName(updatedStock.getMarket());
			s2.setPrice(updatedStock.getPrice());
			stockRepo.save(s2);
			return convertEntityIntoDTO(s2);
		}
		
		return null;
	}

	@Override
	public Stock createStock(Stock stock) {
		StockEntity stockEntity=convertDTOIntoEntity(stock); 
		stockRepo.save(stockEntity);
		return stock;
	}

	@Override
	public Stock getStockById(int id) {
		StockEntity stockEntity1 = stockRepo.getById(id);
		return convertEntityIntoDTO(stockEntity1);
	}

	@Override
	public List<Stock> getAllStocks() {
	
		List<StockEntity> stockList= stockRepo.findAll();
		List<Stock> s1=new ArrayList<>();
		for(StockEntity s: stockList)
			s1.add(convertEntityIntoDTO(s));
		return s1;
	}

	@Override
	public List<Stock> getStockByName() {
		List<StockEntity> stockList= stockRepo.findByName(stockName);
		List<Stock> s1=new ArrayList<>();
		for(StockEntity s: stockList)
			s1.add(convertEntityIntoDTO(s));
		return s1;
	}
	private StockEntity convertDTOIntoEntity(Stock stock) {

		TypeMap<Stock, StockEntity> tMap = model.typeMap(Stock.class, StockEntity.class);
		//TypeMap<Stock,StockEntity> tMap=modelMapper.typeMap(Stock.class, StockEntity.class);
		tMap.addMappings(mapper->{
		mapper.map(Stock::getMarket, StockEntity::setMarketName);
		});
		StockEntity stockEntity=model.map(stock,StockEntity.class);
		return stockEntity;
		}

		private Stock convertEntityIntoDTO(StockEntity stockEntity) {
		TypeMap<StockEntity, Stock> tMap=model.typeMap(StockEntity.class, Stock.class);
		tMap.addMappings(mapper->{
		mapper.map(StockEntity::getMarketName, Stock::setMarket);
		});
		Stock stock=model.map(stockEntity, Stock.class);
		return stock;
		}

		@Override
		public List<Stock> getStocksByName(String stockName) {
			List<StockEntity> stockList= stockRepo.getStocksByNameSQL(stockName);
			List<Stock> s1=new ArrayList<>();
			for(StockEntity s: stockList)
				s1.add(convertEntityIntoDTO(s));
			return s1;
			
		}

		@Override
		public List<Stock> getStocksSortedByName(String sortType) {
			List<StockEntity> stockEntityList=null;
			if("ASC".equalsIgnoreCase(sortType))
				stockEntityList=stockRepo.findByOrderByNameAsc();
			else
				stockEntityList=stockRepo.findByOrderByNameDesc();
			List<StockEntity> stockList= stockRepo.findByOrderByNameAsc();
			List<Stock> s1=new ArrayList<>();
			for(StockEntity s: stockList)
				s1.add(convertEntityIntoDTO(s));
			return s1;
			
		}

		@Override
		public List<Stock> getStocksByPage(int startIndex, int records) {
			Pageable myPageable = PageRequest.of(startIndex, records);
			Page<StockEntity> stockEntityPage= stockRepo.findAll(myPageable);
			List<StockEntity> stockEntityList=stockEntityPage.getContent();
			
			List<StockEntity> stockList= stockRepo.findByOrderByNameAsc();
			List<Stock> s1=new ArrayList<>();
			for(StockEntity s: stockList)
				s1.add(convertEntityIntoDTO(s));
			return s1;
			
		}

		@Override
		public List<Stock> getStocksByNameLike(String namelike) {
			List<StockEntity> stockList= stockRepo.getByNameLikeQuery(namelike);
			List<Stock> s1=new ArrayList<>();
			for(StockEntity s: stockList)
				s1.add(convertEntityIntoDTO(s));
			return s1;
		}

}
