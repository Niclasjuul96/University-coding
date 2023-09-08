// A simple script               Michael R. Hansen 09-09-21

let rec multC n ms = match ms with 
                     | [] -> []
                     | m::tail -> (m*n)::multC n tail;;

