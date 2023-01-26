'use client'

import React, {useRef, useState} from 'react';
import {useRouter} from "next/navigation";

interface SearchbarProps {
  setQuery: (query: string) => void
}

const Searchbar = ({setQuery}: SearchbarProps) => {

  const [textval, setTextval] = useState('');

  const handleFormSubmit = (e: any) => {
    setQuery(textval)
    e.preventDefault()
  }

  return (
      <form onSubmit={handleFormSubmit}>
        <input value={textval} onChange={val => setTextval(val.target.value)}/>
        <button type='submit'>Search</button>
      </form>
  )
};

export default Searchbar;
