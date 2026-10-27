package com.codingshuttle.jpaTutorial.jpaTutorial.controller;

import com.codingshuttle.jpaTutorial.jpaTutorial.entities.ProductEntity;
import com.codingshuttle.jpaTutorial.jpaTutorial.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/products")
public class ProductController {
    private final int pageSize=5;
   private final ProductRepository productRepository;

   public ProductController(ProductRepository productRepository)
   {
       this.productRepository=productRepository;
   }

 //  @GetMapping()
//   public List<ProductEntity> getSortedListByPrice(){
//       return productRepository.findByOrderByPrice();
//   }

   //sorting using Sort, this will sort by using any filed
//  @GetMapping()
//   public List<ProductEntity> getSortedList(@RequestParam(defaultValue = "id") String sortBy){
//       //return productRepository.findBy(Sort.by(Sort.Direction.DESC,sortBy,"price"));
//       return productRepository.findBy(Sort.by(Sort.Order.asc(sortBy),Sort.Order.desc("price")));
//   }


    // ---to implement paging and sorting in same method, and returing a Page object
//    @GetMapping()
//    public Page<ProductEntity>getPagedOutput(@RequestParam(defaultValue = "id") String sortBy,
//                                             @RequestParam(defaultValue = "0") Integer pageNumber)
//   {
//       Pageable pageable= PageRequest
//               .of(pageNumber,
//                       pageSize,
//                       Sort.by(sortBy));
//       return productRepository.findAll(pageable);
//   }


    //to return a list<ProductEntity> from the page class
//    @GetMapping()
//    public List<ProductEntity>getPagedOutput(@RequestParam(defaultValue = "id") String sortBy,
//                                            @RequestParam(defaultValue = "0") Integer pageNumber)
//  {
//      Pageable pageable= PageRequest
//               .of(pageNumber,
//                       pageSize,
//                       Sort.by(sortBy));
//       return productRepository.findAll(pageable).getContent();
//   }

    @GetMapping()
    public List<ProductEntity>getPagedOutput(@RequestParam(defaultValue = "id") String sortBy,
                                             @RequestParam(defaultValue = "0") Integer pageNumber,
                                             @RequestParam(defaultValue = "")String title)
    {

        return productRepository.findByTitleContainingIgnoreCase(title,PageRequest.of(pageNumber,pageSize,Sort.by(sortBy)));
    }
 }
