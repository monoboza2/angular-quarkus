/* tslint:disable */
/* eslint-disable */
// Generated using typescript-generator version 2.29.814 on 2024-06-10 13:34:32.

export interface Page {
    index?: number;
    size?: number;
}

export interface PagedResult<T> {
    content?: T[];
    totalElements?: number;
    currentPage?: number;
    pageSize?: number;
}

export interface Career extends PanacheEntityBase {
    id?: number;
    position?: Position;
    description?: string;
    salaryExpect?: string;
    amountReceived?: number;
    statusPosition?: boolean;
}

export interface CareerDto {
    id?: number;
    position?: Position;
    description?: string;
    salaryExpect?: string;
    amountReceived?: number;
    statusPosition?: boolean;
}

export interface PanacheEntityBase {
}

export type Position = "FRONTEND_DEVELOPER" | "BACKEND_DEVELOPER" | "FULL_STACK_DEVELOPER" | "SYSTEM_ANALYSE" | "TESTER" | "DEVOPS" | "UX_UI";


// Added by 'EnumTypeAliasExtension' extension
export type AllEnumClass = "Position"
// Enum description
//skip Position because it not have getValue() method


// Added by 'EnumTypeArrayExtension' extension
export const PositionArray : Position[]  = ['FRONTEND_DEVELOPER','BACKEND_DEVELOPER','FULL_STACK_DEVELOPER','SYSTEM_ANALYSE','TESTER','DEVOPS','UX_UI']
