// A script file that is based on SimpleLib.fsx              Michael R. Hansen 09-09-2021


#load "SimpleLib.fsx";;
// A script file loaded in this manner is considered a module 
// with same name as that of the file.

// multC is assessed using a qualified name: SimpleLib.multC

// ---- you could also open the module.

open SimpleLib

let double ks = multC 2 ks;;
