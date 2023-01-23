import React from 'react';
import {Product} from "@/app/types";
import ProductCard from "@/app/products/productlist/ProductCard";

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
