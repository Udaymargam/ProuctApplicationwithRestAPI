package com.sathya.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sathya.entity.Discount;
import com.sathya.entity.Product;
import com.sathya.repository.ProductRepo;
@Service
public class ProductServiceImp implements ProductService {
	@Autowired
	private ProductRepo repo;
	@Autowired
	private Discount discount;
	@Override
	public Product saveProduct(Product product) {
		
		double disc=0.0;
		double gst=0.0;
		int deliveryCharges=0;
		double tprice=product.getProductPrice();
		if(product.getProductCategory().equals("Electronics"))
		{
			discount.setProductCategory1("Electronics");
			
			     disc=(tprice*15)/100;
				gst=(tprice*18)/100;
				deliveryCharges=350;
		}
		else if(product.getProductCategory().equals("Home Appliances"))
		{
			discount.setProductCategory1("Home Appliances");
			
			    disc=(tprice*22)/100;
				gst=(tprice*24)/100;
				deliveryCharges=800;
		}
		else if(product.getProductCategory().equals("Clothing"))
		{
			discount.setProductCategory1("Clothing");
			    disc=(tprice*40)/100;
				gst=(tprice*12)/100;
				deliveryCharges=0;
		}
		else if(product.getProductCategory().equals("Furniture"))
		{
			discount.setProductCategory1("Furniture");
			disc=(tprice*10)/100;
				gst=(tprice*18)/100;
				deliveryCharges=300;
		}
		double finalprice=tprice+gst+deliveryCharges-disc;
		discount.setDiscount(disc);
		discount.setGst(gst);
		discount.setDeliveryCharges(deliveryCharges);
		product.setDiscount(discount);
		product.setFinalPrice(finalprice);
		Product p=repo.save(product);
		return p;
	}
	@Override
	public Product getoneRecord(int productId) {
		Product p=repo.findById(productId).get();
		return p;
	}
	@Override
	public List<Product>getAllRecords() {
		List<Product>  getall= repo.findAll();
		return getall;
	}
	@Override
	public void deleteRecord(int productId) {
		
		repo.deleteById(productId);
		
	}
	@Override
	public Product updateProduct(Product product, int productId) {
	    Product oldRecord = repo.findById(productId).orElse(null);

	    if (oldRecord != null) {
	        oldRecord.setProductName(product.getProductName());
	        oldRecord.setProductType(product.getProductType());
	        oldRecord.setProductCategory(product.getProductCategory());
	        oldRecord.setProductPrice(product.getProductPrice());

	        double disc = 0.0;
	        double gst = 0.0;
	        int deliveryCharges = 0;

	        if (product.getProductCategory().equals("Electronics"))
	        {
	            disc = (product.getProductPrice() * 15) / 100;
	            gst = (product.getProductPrice() * 18) / 100;
	            deliveryCharges = 350;
	        } 
	        else if (product.getProductCategory().equals("Home Appliances"))
	        {
	            disc = (product.getProductPrice() * 22) / 100;
	            gst = (product.getProductPrice() * 24) / 100;
	            deliveryCharges = 800;
	        }
	        else if (product.getProductCategory().equals("Clothing")) 
	        {
	            disc = (product.getProductPrice() * 40) / 100;
	            gst = (product.getProductPrice() * 12) / 100;
	            deliveryCharges = 0;
	        } 
	        else if (product.getProductCategory().equals("Furniture")) 
	        {
	            disc = (product.getProductPrice() * 10) / 100;
	            gst = (product.getProductPrice() * 18) / 100;
	            deliveryCharges = 300;
	        }
	        double finalprice=product.getProductPrice()+gst+deliveryCharges-disc;
	        discount.setProductCategory1(product.getProductCategory());
	        discount.setDiscount(disc);
	        discount.setGst(gst);
	        discount.setDeliveryCharges(deliveryCharges);

	        // Set the Discount object to the Product
	        oldRecord.setDiscount(discount);
	        product.setFinalPrice(finalprice);

	        // Save the updated record
	        Product updatedProduct = repo.save(oldRecord);
	        
	            return updatedProduct;
	}
		return null;
	}
}

