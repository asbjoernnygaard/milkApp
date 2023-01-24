export const getAllProductData = async () => {
  const res = await fetch('http://localhost:8080/milkapi')
  if (!res.ok) throw new Error('Failed to fetch data');
  return res.json()
}

export const getProductData = async(productId: string) => {
  const res = await fetch(`http://localhost:8080/milkapi/${productId}`)
  if (!res.ok) throw new Error('Failed to fetch data');
  return res.json()
}