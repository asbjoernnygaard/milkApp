import React from 'react';
import {Product} from "@/app/types";
import Image from "next/image";

const Product = ({id, name, type, storage}: Product) => {
  // if there is already product data for this product, use it. Else, fetch

  return (
      <article>
        <Image src={'/milk.png'} alt={'product'} width={200} height={200}/>
        <h3>{name}</h3>
        <h4>{type}</h4>
        <div>stock:{' ' + storage}</div>
        <button>add to cart</button>
      </article>
  );
};

export default Product;
