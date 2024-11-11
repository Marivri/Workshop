export interface AstronomicalObject {
    id: number;
    name: string;
    type: string;
    distanceFromEarth: number;
    brightness: number;
    coordinates: Coordinates
    starClass: string;
    hemisphere: string;
}

export interface Coordinates {
    RA: number
    Dec: number
}