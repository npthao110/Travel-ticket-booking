package com.viethuynh;

public class Travel {
    private int id;
    private String name;
    private String price;
    private String imageDescription;
    private String detailDescription;
    private String startDate;
    private String endDate;
    private String address;
    private String votes;

    // Constructors, getters, setters...
    
    // Constructor
    public Travel(int id, String name, String price, String imageDescription, String detailDescription, String startDate, String endDate, String address, String votes) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageDescription = imageDescription;
        this.detailDescription = detailDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.address = address;
        this.votes = votes;
    }
    
    public Travel(String name, String price, String imageDescription, String detailDescription, String startDate, String endDate, String address, String votes) {
        this.name = name;
        this.price = price;
        this.imageDescription = imageDescription;
        this.detailDescription = detailDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.address = address;
        this.votes = votes;
    }
    
    public Travel(String name, String price, String imageDescription, String detailDescription, String startDate, String endDate, String address) {
        this.name = name;
        this.price = price;
        this.imageDescription = imageDescription;
        this.detailDescription = detailDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.address = address;
    }
    
    public Travel(int id, String name, String price, String imageDescription, String detailDescription, String startDate, String endDate, String address) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageDescription = imageDescription;
        this.detailDescription = detailDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.address = address;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public String getVotes() {
		return votes;
	}

	public void setVotes(String votes) {
		this.votes = votes;
	}

	public void setPrice(String price) {
        this.price = price;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
