'use client'
import React, {useEffect, useState} from 'react';
import ProductList from "@/app/products/productlist/ProductList";
import {Product} from "@/app/types";

const Page = () => {

  const [products, setProducts] = useState<Product[] | null>(null);

  useEffect(() => {
    fetch('http://localhost:8080/milkapi')
        .then(res => res.json())
        .then(res => setProducts(res))
        .catch(err => console.log(err))
  }, []);

  if (!products) return (<div>Loading products...</div>)

  return (
      <div>
        <ProductList products={products}/>
      </div>
  );
};

export default Page;
