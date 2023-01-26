'use client'

import React, {useState} from 'react';
import {useRouter} from "next/navigation";

const Searchbar = () => {

  const [query, setQuery] = useState('');
  const router = useRouter();

  const handleFormSubmit = (e:any) => {
    e.preventDefault();
    router.push(`/products?query=${query}`);
  }

  return (
      <form onSubmit={e => handleFormSubmit(e)}>
        <input value={query} onChange={e => setQuery(e.target.value)}/>
        <button type='submit'>Search</button>
      </form>
  )
};

export default Searchbar;
