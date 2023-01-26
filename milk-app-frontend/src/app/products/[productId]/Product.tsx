import React from 'react';
import {Product} from "@/src/types";
import Image from "next/image";

interface ProductProps {
  product: Product
}

const Product = ({product}: ProductProps) => {
  const {id, name, type, storage}: Product = product;

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
