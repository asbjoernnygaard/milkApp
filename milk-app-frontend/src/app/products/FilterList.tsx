'use client'

import React, {useState} from 'react';
import {useRouter} from "next/navigation";

interface ProductTypes {
  types: {type: string}[]
}

const FilterList = ({types}: ProductTypes) => {

  const router = useRouter();

  const handleFormSubmit = (e:any, type: string) => {
    e.preventDefault();
    if (e.target.value === 'on') {
      router.push(`/products?type=${type}`);
    } else {
      router.push('/products');
    }
  }

  return (
      <div>
        {types.map(type => {
          return (
              <label>
                <input type="checkbox" onClick={e => handleFormSubmit(e, type.type)}/>
                {type.type}
              </label>)
        })}
      </div>
  );
};

export default FilterList;
