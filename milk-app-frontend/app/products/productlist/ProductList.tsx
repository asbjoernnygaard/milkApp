import React from 'react';
import {Product} from "@/app/types";
import ProductCard from "@/app/products/productlist/ProductCard";
import {getAllProductData} from "@/app/products/getAllProductData";

interface ProductListProps {

}

// const ProductList = async ({products}: ProductListProps) => {
const ProductList = async () => {

  const products: Product[] = await getAllProductData()

  return (
      <ul>
        {products.map(product => <ProductCard product={product}/>)}
      </ul>
  );
};

export default ProductList;
