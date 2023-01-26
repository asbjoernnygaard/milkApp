import React from 'react';
import ProductList from "@/src/app/products/(components)/(productlist)/ProductList";
import {fetchFunctions} from "@/src/fetchFunctions";
import ProductFilteringUI from "@/src/app/products/(components)/ProductFilteringUI";

const Page = async ({searchParams}: {searchParams: {page: number, type: Set<string>, query: string}}) => {
  const {page, type, query} = searchParams;

  const {products} = await fetchFunctions(page, type, query)

  return (
      <div>
        <ProductFilteringUI/>
        <ProductList products={products}/>
      </div>
  );
};

export default Page;
