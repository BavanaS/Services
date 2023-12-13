package com.quinbay.CustomerService.controller;

import com.quinbay.CustomerService.controller.HttpController;
import com.quinbay.CustomerService.model.vo.ProductVO;
import com.quinbay.CustomerService.service.CustomerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Service("customerServiceInterface")
public class CustomerGateway implements CustomerServiceInterface
{
    @Autowired
    RestTemplate restTemplate;

    private String baseUrl="http://localhost:8086/httpInventoryService";

    @Override
    public List<ProductVO> getProduct()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(baseUrl + "/inventoryServiceGet").build();

        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, List.class).getBody();
    }

    @Override
    public List<ProductVO> getFilterProduct(String name)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        UriComponents builder=UriComponentsBuilder.fromHttpUrl(baseUrl+"/inventoryServiceGetFilter").queryParam("name",name).build();
        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, List.class).getBody();
    }

    @Override
    public String postProductList(ProductVO product)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity(product, headers);
        return restTemplate.exchange(baseUrl+"/inventoryAdd", HttpMethod.POST, entity,String.class).getBody();

    }

    @Override
    public String updateProductList(ProductVO product,Long id)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity(product,headers);
        UriComponents builder=UriComponentsBuilder.fromHttpUrl(baseUrl+"/inventoryUpdate").queryParam("id",id).build();
        return restTemplate.exchange(builder.toUriString(), HttpMethod.PUT, entity, String.class).getBody();
    }


    @Override
    public String deleteProductList(ProductVO product)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity(product, headers);
        return restTemplate.exchange(baseUrl+"/inventoryDelete", HttpMethod.DELETE, entity,String.class).getBody();
    }
}
