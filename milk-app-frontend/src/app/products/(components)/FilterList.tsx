'use client'

import React, {useEffect, useState} from 'react';
import {getProductTypes} from "@/src/fetchFunctions";

interface FilterListProps {
  changeActiveTypes: (type: string, operand: 'add' | 'del') => void
}

const FilterList = ({changeActiveTypes}: FilterListProps) => {

  const [types, setTypes] = useState([]);

  useEffect(() => {
    getProductTypes().then(data => data
        .map((e: {type: string}) => e.type))
        .then((data) => setTypes(data));
  }, []);

  const handleChange = (
      e: any
  ) => {
    const { value, checked } = e.target;
    changeActiveTypes(value, checked ? 'add' : 'del');
  }

  return (
      <form>
        {types.map(type => {
          return (
              <label key={type}>
                <input type="checkbox" value={type} onChange={handleChange}/>
                {type}
              </label>
          )
        })}
      </form>
  );
};

export default FilterList;
