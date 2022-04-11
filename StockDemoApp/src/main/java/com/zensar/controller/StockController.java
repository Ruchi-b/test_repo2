package com.zensar.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import com.zensar.dto.Stock;
import com.zensar.entity.StockEntity;
import com.zensar.service.StockService;




@RestController
@RequestMapping("/stockapp")
@CrossOrigin(origins="*")
public class StockController {





/*
* In REST API, we have 3 types of parameters: Path parameter/Template parameter
* - /stock/{id} - @PathVariable Query parameter - /stock?id=3 - @RequestParam
* Header parameter - pass through header - @RequestHeader
*/

@Autowired
StockService stockService;

@GetMapping(value="/employee")
public boolean testRequestParam(@RequestParam(value="eid",required = false)int empId) {
System.out.println("Emp id:"+empId);
return true;
}

@GetMapping(value="/employee2")
public boolean testHeaderParam(@RequestHeader(value="auth-token")String authToken) {
System.out.println("Auth Token = "+authToken);
return true;
}


@GetMapping(value="/stock", produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public List<Stock> getAllStocks(){
return stockService.getAllStocks();
}

@GetMapping(value="/stock/{id}", produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public Stock getStockById(@PathVariable("id") int id){
return stockService.getStockById(id);
}

@PostMapping(value="/stock", consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public Stock createStock(@RequestBody Stock stock) {
return stockService.createStock(stock);
}

@PutMapping(value="/stock/{id}", consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public Stock updateStock(@PathVariable("id") int stockId,@RequestBody Stock updatedStock) {
return stockService.updateStock(stockId, updatedStock);
}

@DeleteMapping(value="/stock/{id}")
public boolean deleteStockById(@PathVariable("id") int stockId) {
return stockService.deleteStockById(stockId);
}

@DeleteMapping(value="/stock")
public boolean deleteAllStocks() {
return stockService.deleteAllStocks();
}

@GetMapping(value="/stock/name", produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public List<Stock> getStockByName(){
return stockService.getStockByName();
}
	//////
@GetMapping(value="/stock/name/{name}", produces= { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public ResponseEntity<List<Stock>> getStocksByName(@PathVariable("name") String stockName) {
return new ResponseEntity<List<Stock>>(stockService.getStocksByName(stockName), HttpStatus.OK);
}



@GetMapping(value="/stock/sort/{sortType}", produces= { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public ResponseEntity<List<Stock>> getStocksSortedByName(@PathVariable("sortType") String sortType) {
return new ResponseEntity<List<Stock>>(stockService.getStocksSortedByName(sortType), HttpStatus.OK);
}



@GetMapping(value="/stock/{startIndex}/{records}", produces= { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public ResponseEntity<List<Stock>> getStocksByPage(@PathVariable("startIndex") int startIndex,
@PathVariable("records") int records) {
return new ResponseEntity<List<Stock>>(stockService.getStocksByPage(startIndex, records), HttpStatus.OK);
}



@GetMapping(value="/stock/like/{namelike}", produces= { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public ResponseEntity<List<Stock>> getStocksByNameLike(@PathVariable("namelike") String namelike) {
return new ResponseEntity<List<Stock>>(stockService.getStocksByNameLike(namelike), HttpStatus.OK);
}


}
