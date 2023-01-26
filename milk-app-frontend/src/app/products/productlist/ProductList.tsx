import React from 'react';
import {Product, ProductListResponse} from "@/src/types";
import ProductCard from "@/src/app/products/productlist/ProductCard";

interface ProductListProps {
  products: Product[]
}

const ProductList = ({products}: ProductListProps) => {

  return (
      <ul>
        {products.map(product => <ProductCard product={product}/>)}
      </ul>
  );
};

export default ProductList;
