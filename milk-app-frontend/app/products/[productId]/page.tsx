import React from 'react';

const Page = ({params} : {params: {productId: string}}) => {

  return (
      <div>
        {'productId: ' + params.productId}
      </div>
  )
};

export default Page;