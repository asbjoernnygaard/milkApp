import React from 'react';
import Product from "@/app/products/[productId]/Product";
import {getProductData} from "@/app/products/getAllProductData";

const Page = async ({params} : {params: {productId: string}}) => {

  const product = await getProductData(params.productId)

  return (
      <div>
        {/* @ts-expect-error Server Component */}
        <Product product={product}/>
      </div>
  )
};

export default Page;