import React from 'react';
import Product from "@/src/app/products/[productId]/Product";
import {getProductData} from "@/src/fetchFunctions";

const Page = async ({params} : {params: {productId: string}}) => {

  const product = await getProductData(params.productId)

  return (
      <div>
        <Product product={product}/>
      </div>
  )
};

export default Page;