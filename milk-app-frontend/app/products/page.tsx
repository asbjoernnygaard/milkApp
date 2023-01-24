import React from 'react';
import ProductList from "@/app/products/productlist/ProductList";
import {Product} from "@/app/types";
import {getAllProductData} from "@/app/products/getAllProductData";

const Page = () => {
  return (
      <div>
        {/* @ts-expect-error Server Component */}
        <ProductList/>
      </div>
  );
};

export default Page;
