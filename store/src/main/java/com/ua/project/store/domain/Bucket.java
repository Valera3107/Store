package com.ua.project.store.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "bucket")
public class Bucket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user", referencedColumnName = "id")
	private User user;

	@ManyToOne(targetEntity = Product.class)
	@JoinColumn(name = "product", referencedColumnName = "id")
	private Product product;

	@Column(name = "purchase_date")
	private Date purchaseDate;

	public Bucket(Integer id, User user, Product product, Date purchaseDate) {
		this.id = id;
		this.user = user;
		this.product = product;
		this.purchaseDate = purchaseDate;
	}

	public Bucket(User user, Product product, Date purchaseDate) {
		this.user = user;
		this.product = product;
		this.purchaseDate = purchaseDate;
	}

	public Bucket() {
	}

	public Bucket(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bucket other = (Bucket) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (purchaseDate == null) {
			if (other.purchaseDate != null)
				return false;
		} else if (!purchaseDate.equals(other.purchaseDate))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bucket [id=" + id + ", user=" + user + ", product=" + product + ", purchaseDate=" + purchaseDate
				+ "]";
	}

}
