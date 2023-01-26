'use client'

import React, {useEffect, useState} from 'react';
import FilterList from "@/src/app/products/(components)/FilterList";
import Searchbar from "@/src/app/products/(components)/Searchbar";
import {generateUriFromQueries} from "@/src/fetchFunctions";
import {useRouter} from "next/navigation";

const ProductFilteringUI = () => {

  const [query, setQuery] = useState('');
  const [activeTypes, setActiveTypes] = useState<Set<string>>(new Set<string>());
  const router = useRouter()


  useEffect(() => {
    //if (!query && !activeTypes.size) return

    //forgot about page

    const url = generateUriFromQueries(1, query, activeTypes);
    console.log(url)
    //const url = `products?${query && 'query=' + query}${activeTypes.size ? ((query && '&') + 'types=' + Array.from(activeTypes).join(',').replaceAll(' ', '%20')):''}`
    router.push(url)

  }, [query, activeTypes]);


  const changeActiveTypes = (type: string, operand: 'add' | 'del') => {
    const updatedActiveTypes = new Set(activeTypes);
    if (operand === 'add') updatedActiveTypes.add(type)
    if (operand === 'del') updatedActiveTypes.delete(type)
    setActiveTypes(updatedActiveTypes)
  }

  return (
      <div>
        <Searchbar setQuery={setQuery}/>
        <FilterList changeActiveTypes={changeActiveTypes}/>
      </div>
  );
};

export default ProductFilteringUI;
