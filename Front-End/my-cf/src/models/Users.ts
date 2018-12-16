import { Carts } from "./Carts";
import { Roles } from "./Roles";

export class Users {
    id: number;
    birthday: Date;
    gender: Number;
    avatar:String;
    address: String;
    phone: String;
    email: String;
    password: String;
    firstname: String;
    lastname: String;
    status: Number;
    description: String;
    cart:Carts;
    role:Roles;
}
