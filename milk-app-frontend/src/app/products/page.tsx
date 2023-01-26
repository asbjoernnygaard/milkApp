import React from 'react';
import ProductList from "@/src/app/products/productlist/ProductList";
import {fetchFunctions, getProductTypes} from "@/src/fetchFunctions";
import Searchbar from "@/src/app/products/Searchbar";
import FilterList from "@/src/app/products/FilterList";
import * as console from "console";

const Page = async ({searchParams}: {searchParams: {page: number, type: string, query: string}}) => {
  const {page, type, query} = searchParams;

  const {products} = await fetchFunctions(page, type, query)
  const types = await getProductTypes();

  return (
      <div>
        <Searchbar/>
        <FilterList types={types}/>
        <ProductList products={products}/>
      </div>
  );
};

export default Page;
