package com.olx.dto;

	import java.time.LocalDate;
	import java.util.List;
	import java.util.Locale.Category;

	import ch.qos.logback.core.status.Status;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
	
@ApiModel(value="Login DTO")
public class Advertise {
	
	@ApiModelProperty(value="Advertise identifier")
	private int id;
	@ApiModelProperty(value="Advertise title")
	private String title;
	@ApiModelProperty(value="Advertise price")
	private int price;
	@ApiModelProperty(value="Advertise category")
	private String category;
	@ApiModelProperty(value="Advertise description")
	private String description;
	@ApiModelProperty(value="Advertise username")
	private String userName;
	@ApiModelProperty(value="Advertise date")
	private LocalDate createdDate;
	@ApiModelProperty(value="Advertise modified date")
	private LocalDate modifiedDate;
	@ApiModelProperty(value="Advertise status")
	private String status;
	public Advertise(int id, String title, int price, String category, String description, String userName,
		LocalDate createdDate, LocalDate modifiedDate, String status) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.category = category;
		this.description = description;
		this.userName = userName;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.status = status;
		}
		public Advertise() {
		
		}
		public int getId() {
		return id;
		}
		public void setId(int id) {
		this.id = id;
		}
		public String getTitle() {
		return title;
		}
		public void setTitle(String title) {
		this.title = title;
		}
		public int getPrice() {
		return price;
		}
		public void setPrice(int price) {
		this.price = price;
		}
		public String getCategory() {
		return category;
		}
		public void setCategory(String category) {
		this.category = category;
		}
		public String getDescription() {
		return description;
		}
		public void setDescription(String description) {
		this.description = description;
		}
		public String getUserName() {
		return userName;
		}
		public void setUserName(String userName) {
		this.userName = userName;
		}
		public LocalDate getCreatedDate() {
		return createdDate;
		}
		public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
		}
		public LocalDate getModifiedDate() {
		return modifiedDate;
		}
		public void setModifiedDate(LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
		}
		public String getStatus() {
		return status;
		}
		public void setStatus(String status) {
		this.status = status;
		}
		@Override
		public String toString() {
		return "Advertise [id=" + id + ", title=" + title + ", price=" + price + ", category=" + category
		+ ", description=" + description + ", userName=" + userName + ", createdDate=" + createdDate
		+ ", modifiedDate=" + modifiedDate + ", status=" + status + "]";
		}
		public static List<Category> getAllCategories() {
			// TODO Auto-generated method stub
			return null;
		}
		public static List<Status> getAllStatus() {
			// TODO Auto-generated method stub
			return null;
		}
		public static List<Advertise> searchAdvertisesByFilterCriteria(String searchText, int categoryId, String postedBy,
				String dateCondition, LocalDate onDate, LocalDate fromDate, LocalDate toDate, String sortedBy,
				int startIndex, int records) {
			// TODO Auto-generated method stub
			return null;
		}



}
