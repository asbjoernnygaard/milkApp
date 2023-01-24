import React from 'react';
import {Product} from "@/app/types";
import Image from "next/image";
import Link from "next/link";

interface ProductCardProps {
  product: Product
}

const ProductCard = ({product}: ProductCardProps) => {
  const {id, name, type, storage} = product;

  const productPageUrl = `/products/${id}`

  return (
      <li>
        <Link href={productPageUrl}>
          <Image src={'/milk.png'} alt={'product'} width={200} height={200}/>
        </Link>
        <Link href={productPageUrl}>
          <h3>{name}</h3>
        </Link>
        <h4>{type}</h4>
        <div>stock:{' ' + storage}</div>
      </li>
  );
};

export default ProductCard;
